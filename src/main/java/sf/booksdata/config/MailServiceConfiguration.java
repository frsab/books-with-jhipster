package sf.booksdata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;


@Configuration
@EnableJpaRepositories("sf.booksdata.repository")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class MailServiceConfiguration {
    @Autowired
    YAMLGmailAccountConfiguration gmailAccountConfiguration;
    private final Logger log = LoggerFactory.getLogger(MailServiceConfiguration.class);

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

       // mailSender.setUsername("springboot.mailtesting@gmail.com");
        log.warn("mail {}",gmailAccountConfiguration.getEmail());
        log.warn("getPassword {}",gmailAccountConfiguration.getPassword());
        mailSender.setUsername(gmailAccountConfiguration.getEmail());
        mailSender.setPassword(gmailAccountConfiguration.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }





}
