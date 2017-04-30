package com.v2.myskeleton;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.context.embedded.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //空いてるポートでテストサーバーは適当に起動
public class MySkeletonV2ApplicationTests {
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@LocalServerPort //localのサーバーポートにアクセス
	int port;

	//Hello worldがRestで帰ってきたらテスト成功。Hello worldを書き換えると、テストに失敗する。実行→Junitで確認できる
	@Test
	public void contextLoads(){
		assertThat(restTemplate.getForObject("http://localhost:" + port, String.class), 	is("Hello world"));
	}

}
