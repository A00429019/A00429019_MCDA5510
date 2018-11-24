<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAssignment3ServiceProxyid" scope="session" class="com.mcda5510.service.Assignment3ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAssignment3ServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAssignment3ServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAssignment3ServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mcda5510.service.Assignment3Service getAssignment3Service10mtemp = sampleAssignment3ServiceProxyid.getAssignment3Service();
if(getAssignment3Service10mtemp == null){
%>
<%=getAssignment3Service10mtemp %>
<%
}else{
        if(getAssignment3Service10mtemp!= null){
        String tempreturnp11 = getAssignment3Service10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String ID_1id=  request.getParameter("ID16");
        int ID_1idTemp  = Integer.parseInt(ID_1id);
        String nameOnCard_2id=  request.getParameter("nameOnCard18");
            java.lang.String nameOnCard_2idTemp = null;
        if(!nameOnCard_2id.equals("")){
         nameOnCard_2idTemp  = nameOnCard_2id;
        }
        String cardNumber_3id=  request.getParameter("cardNumber20");
            java.lang.String cardNumber_3idTemp = null;
        if(!cardNumber_3id.equals("")){
         cardNumber_3idTemp  = cardNumber_3id;
        }
        String unitPrice_4id=  request.getParameter("unitPrice22");
        double unitPrice_4idTemp  = Double.parseDouble(unitPrice_4id);
        String qty_5id=  request.getParameter("qty24");
        int qty_5idTemp  = Integer.parseInt(qty_5id);
        String totalPrice_6id=  request.getParameter("totalPrice26");
        double totalPrice_6idTemp  = Double.parseDouble(totalPrice_6id);
        String expDate_7id=  request.getParameter("expDate28");
            java.lang.String expDate_7idTemp = null;
        if(!expDate_7id.equals("")){
         expDate_7idTemp  = expDate_7id;
        }
        java.lang.String insertTrxns13mtemp = sampleAssignment3ServiceProxyid.insertTrxns(ID_1idTemp,nameOnCard_2idTemp,cardNumber_3idTemp,unitPrice_4idTemp,qty_5idTemp,totalPrice_6idTemp,expDate_7idTemp);
if(insertTrxns13mtemp == null){
%>
<%=insertTrxns13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertTrxns13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 30:
        gotMethod = true;
        java.lang.String selectTrxns30mtemp = sampleAssignment3ServiceProxyid.selectTrxns();
if(selectTrxns30mtemp == null){
%>
<%=selectTrxns30mtemp %>
<%
}else{
        String tempResultreturnp31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(selectTrxns30mtemp));
        %>
        <%= tempResultreturnp31 %>
        <%
}
break;
case 33:
        gotMethod = true;
        String ID_8id=  request.getParameter("ID36");
            java.lang.String ID_8idTemp = null;
        if(!ID_8id.equals("")){
         ID_8idTemp  = ID_8id;
        }
        java.lang.String removeTrxns33mtemp = sampleAssignment3ServiceProxyid.removeTrxns(ID_8idTemp);
if(removeTrxns33mtemp == null){
%>
<%=removeTrxns33mtemp %>
<%
}else{
        String tempResultreturnp34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeTrxns33mtemp));
        %>
        <%= tempResultreturnp34 %>
        <%
}
break;
case 38:
        gotMethod = true;
        String ID_9id=  request.getParameter("ID41");
            java.lang.String ID_9idTemp = null;
        if(!ID_9id.equals("")){
         ID_9idTemp  = ID_9id;
        }
        String nameOnCard_10id=  request.getParameter("nameOnCard43");
            java.lang.String nameOnCard_10idTemp = null;
        if(!nameOnCard_10id.equals("")){
         nameOnCard_10idTemp  = nameOnCard_10id;
        }
        String cardNumber_11id=  request.getParameter("cardNumber45");
            java.lang.String cardNumber_11idTemp = null;
        if(!cardNumber_11id.equals("")){
         cardNumber_11idTemp  = cardNumber_11id;
        }
        String unitPrice_12id=  request.getParameter("unitPrice47");
            java.lang.String unitPrice_12idTemp = null;
        if(!unitPrice_12id.equals("")){
         unitPrice_12idTemp  = unitPrice_12id;
        }
        String qty_13id=  request.getParameter("qty49");
            java.lang.String qty_13idTemp = null;
        if(!qty_13id.equals("")){
         qty_13idTemp  = qty_13id;
        }
        String totalPrice_14id=  request.getParameter("totalPrice51");
            java.lang.String totalPrice_14idTemp = null;
        if(!totalPrice_14id.equals("")){
         totalPrice_14idTemp  = totalPrice_14id;
        }
        String expDate_15id=  request.getParameter("expDate53");
            java.lang.String expDate_15idTemp = null;
        if(!expDate_15id.equals("")){
         expDate_15idTemp  = expDate_15id;
        }
        java.lang.String updateTrxns38mtemp = sampleAssignment3ServiceProxyid.updateTrxns(ID_9idTemp,nameOnCard_10idTemp,cardNumber_11idTemp,unitPrice_12idTemp,qty_13idTemp,totalPrice_14idTemp,expDate_15idTemp);
if(updateTrxns38mtemp == null){
%>
<%=updateTrxns38mtemp %>
<%
}else{
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTrxns38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>