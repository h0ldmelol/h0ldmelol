package account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfigurerImpl extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin1").roles("ADMIN")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .csrf().disable().headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/signup").permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("api/auth/changepass")
//                .hasAnyRole(UserRoles.USER.name(),
//                        UserRoles.ACCOUNTANT.name())
//                .mvcMatchers("api/empl/payment")
//                        .hasAnyRole(UserRoles.ACCOUNTANT.name(), UserRoles.USER.name())
//                .mvcMatchers("api/acct/*")
//                        .hasRole(UserRoles.ACCOUNTANT.name())
//                .mvcMatchers("api/admin/*")
//                        .hasRole(UserRoles.ADMINISTRATOR.name())
//                .mvcMatchers("api/auth/signup", "api/register").permitAll()
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable()
//                .and()
//                .httpBasic();
//    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
