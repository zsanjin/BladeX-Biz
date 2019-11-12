package org.springblade.websocket;

import org.springblade.core.launch.BladeApplication;
import org.springblade.core.launch.constant.AppConstant;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WebSocketApplication
 *
 * @author Chill
 */
@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		BladeApplication.run(AppConstant.APPLICATION_WEBSOCKET_NAME, WebSocketApplication.class, args);
	}

}
