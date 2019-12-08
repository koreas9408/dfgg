package kr.ac.dongyang.dfgg.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target -> 메소드의 파라미터로 선언된 객체에서만 사용할 수 있다.
// 클래스 선언문에 쓸 수 있는 TYPE도 있다.
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

}
