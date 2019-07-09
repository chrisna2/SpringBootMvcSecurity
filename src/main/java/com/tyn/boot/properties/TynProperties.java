package com.tyn.boot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("tyninfo")//추가 의존성 파일 삽입
public class TynProperties {
	
	private int enpNo = 12312312;
	private String enpNm = "동양네트웍스";
	private String enpType = "주식회사";
	
	public int getEnpNo() {
		return enpNo;
	}
	public void setEnpNo(int enpNo) {
		this.enpNo = enpNo;
	}
	public String getEnpNm() {
		return enpNm;
	}
	public void setEnpNm(String enpNm) {
		this.enpNm = enpNm;
	}
	public String getEnpType() {
		return enpType;
	}
	public void setEnpType(String enpType) {
		this.enpType = enpType;
	}
	
	
	

}
