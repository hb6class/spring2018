{"guests":[
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:forEach items="${alist }" var="bean" varStatus="status">
		<c:if test="${status.index !=0 }">,</c:if>
		{"sabun":${bean.sabun },"name":"${bean.name }","nalja":"${bean.nalja }","pay":${bean.pay }}
	</c:forEach>
]}