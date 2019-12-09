package com.wanglu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wanglu.domain.User;
import com.wanglu.utils.UserUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis.xml")
public class UserTest {
	@Autowired
	private RedisTemplate redisTemplate;
	//测试jdk
	@Test
	public void jdkTest(){
		//开始时间
		long start = System.currentTimeMillis();
		//循环形成50000条数据
		for (int i = 1; i <= 50000; i++) {
			//使用工具类，构建值
			Integer id = i;
			String name = UserUtils.getName();
			String gender = UserUtils.getSex();
			String phone = UserUtils.getPhone();
			String mail = UserUtils.getMail();
			String birthday = UserUtils.getBirthday();
			User u = new User(id, name, gender, phone, mail, birthday);
			redisTemplate.opsForValue().set("user"+i, u);
		}//结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式是jdk");
		System.out.println("数量50000");
		System.out.println("使用时间是"+(end-start));
	}
	//测试json
	@Test
	public void jsonTest(){
		//开始时间
		long start = System.currentTimeMillis();
		//循环形成50000条数据
		for (int i = 1; i <= 50000; i++) {
			//使用工具类，构建值
			Integer id = i;
			String name = UserUtils.getName();
			String gender = UserUtils.getSex();
			String phone = UserUtils.getPhone();
			String mail = UserUtils.getMail();
			String birthday = UserUtils.getBirthday();
			User u = new User(id, name, gender, phone, mail, birthday);
			redisTemplate.opsForValue().set("user"+i, u);
		}//结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式是json");
		System.out.println("数量50000");
		System.out.println("使用时间是"+(end-start));
	}
	//测试hash
	@Test
	public void hashTest(){
		//开始时间
		long start = System.currentTimeMillis();
		//循环形成50000条数据
		for (int i = 1; i <= 50000; i++) {
			//使用工具类，构建值
			Integer id = i;
			String name = UserUtils.getName();
			String gender = UserUtils.getSex();
			String phone = UserUtils.getPhone();
			String mail = UserUtils.getMail();
			String birthday = UserUtils.getBirthday();
			User u = new User(id, name, gender, phone, mail, birthday);
			redisTemplate.opsForHash().put("users"+i, "user"+i, u.toString());
		}
		//结束时间
		long end = System.currentTimeMillis();
		System.out.println("序列化方式是hash");
		System.out.println("数量50000");
		System.out.println("使用时间是"+(end-start));
	}
}


















