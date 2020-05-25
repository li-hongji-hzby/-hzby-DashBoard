package cn.hzby.lhj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 启动定时器
@EnableCaching // 开启缓存
@MapperScan(basePackages = "cn.hzby.lhj.mapper")
public class DashBoardServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashBoardServerApplication.class, args);
	}

}
