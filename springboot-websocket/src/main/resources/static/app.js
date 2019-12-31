var stompClient = null;
var uId = null;
var gId = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/springboot-websocket');
    uId = $("#u_id").val();
    if(uId == null) {
    	alert("请输入u_id");
    	return;
    }
    gId = $("#g_id").val();
    if(gId == null) {
    	alert("请输入g_id");
    	return;
    }
    console.log('u_id: ' + uId);
    console.log('g_id: ' + gId)
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/' + gId + '/topic', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/user/' + gId + '/topic2', function (greeting) {
            alert(greeting);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/chat", {
	    	'uId': uId,
	    	'gId' : gId
	    }, 
	    JSON.stringify({'message': $("#message").val(),'uId':uId,'gId':gId})
    );
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

