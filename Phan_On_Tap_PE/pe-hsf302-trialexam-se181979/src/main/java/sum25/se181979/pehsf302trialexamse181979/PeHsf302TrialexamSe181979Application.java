package sum25.se181979.pehsf302trialexamse181979;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"hsf302.se.fu.vn.controllers","hsf302.se.fu.vn.services"})
//@EnableJpaRepositories(basePackages = "hsf302.se.fu.vn.repositories")
//@EntityScan(basePackages = "hsf302.se.fu.vn")

public class PeHsf302TrialexamSe181979Application {

    public static void main(String[] args) {
        SpringApplication.run(PeHsf302TrialexamSe181979Application.class, args);
    }

}
