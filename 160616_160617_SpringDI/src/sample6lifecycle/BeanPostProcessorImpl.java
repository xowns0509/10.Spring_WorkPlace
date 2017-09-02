package sample6lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {

	/**
	 * BeanPostProcessor를 위한 postProcessAfterInitialization 오버라이딩
	 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("8. 사전초기화 작업 postProcessAfterInitialization 실행");
		return arg0;
	}

	/**
	 * BeanPostProcessor를 위한 postProcessBeforeInitialization 오버라이딩
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("5. 사전초기화 작업 postProcessBeforeInitialization 실행");
		return arg0;
	}

}
