package cn.hzby.lhj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling /** 启动定时器  **/
@MapperScan(basePackages = "cn.hzby.lhj.mapper")
/**
 * @author lhj
 */
public class DashBoardServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardServerApplication.class, args);
	}

}
