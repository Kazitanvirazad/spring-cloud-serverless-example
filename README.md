## SPRING CLOUD FUNCTION EXAMPLE PROJECT

#### AWS Serverless Lambda Function name - subscriber
#### Available functions to invoke
<pre>
<ol>
<li>addEmail - HTTP POST method to add email</li>
<li>getEmailList - HTTP GET method to get email list</li>
<li>getEmailById - HTTP GET method to get email list by email id</li>
<li>uppercase - HTTP ANY method to change the input String to uppercase</li>
<li>lowercase - HTTP ANY method to change the input String to lowercase</li>
<li>reverse - HTTP ANY method to change the input String to reverse</li>

</ol>
</pre>
#### Note: To invoke a particular Function HTTP Header attribute "spring.cloud.function.definition" must be added with function name as the value