Monitoring Sample
=================
This a sample [Spring Integration](http://www.springsource.org/spring-integration/) application called [monitoring](https://github.com/SpringSource/spring-integration-samples/tree/master/intermediate/monitoring) modified to demonstrate a programmatic access to JMX exposed components.

It exports two channels metrics:
* twitterChannelMetrics - common SI channel
* jmsChannelMetrics - a channel backed by JMS queue

Both channel metrics are used within a simple [Spring MVC controller](https://github.com/michaljemala/playground/blob/master/monitoring/src/main/java/org/springframework/integration/mvc/controller/ChannelMetricsController.java) in order to get value of timeSinceLastSend JMX attribute.
