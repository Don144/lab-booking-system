package lk.hasi.labbookingsystem.config;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.hasi.labbookingsystem.dto.UserDto;
import lk.hasi.labbookingsystem.security.AutUserDetailsImpl;
import lk.hasi.labbookingsystem.security.JWTServiceImpl;
import lk.hasi.labbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JWTServiceImpl jwtService;
  @Autowired
  private UserService userService;
  @Autowired
  AutUserDetailsImpl autUserDetails;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    String jwtToken = null;
    final String userName=null;

    if(authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }

    jwtToken = authHeader.substring(7);
    jwtService.extractUserName(jwtToken);
    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDto userDto = userService.findByUser(userName);
      UserDetails userDetails = new User(userDto.getUserName(),userDto.getPassword(),new ArrayList<>());
      if (jwtService.isTokenValid(jwtToken,userDetails)) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
            null,
            userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)
        );
        securityContext.setAuthentication(authToken);
        SecurityContextHolder.setContext(securityContext);
      }
    }
    filterChain.doFilter(request, response);

  }
}

