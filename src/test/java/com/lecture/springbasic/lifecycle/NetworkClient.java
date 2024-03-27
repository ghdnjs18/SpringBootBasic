package com.lecture.springbasic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void call(String message) {
        System.out.println("call : " + url + ", message : " + message);
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void dissonnect() {
        System.out.println("close : " + url);
    }

    // InitializingBean에서 메서드로 초기화를 지원한다.
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }

    // DisposableBean에서 메서드로 소멸을 지원한다.
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        dissonnect();
//    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        dissonnect();
    }
}
