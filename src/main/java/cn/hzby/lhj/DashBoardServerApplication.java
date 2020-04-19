package cn.hzby.lhj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.hzby.lhj.mapper")
public class DashBoardServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardServerApplication.class, args);
	}

}
