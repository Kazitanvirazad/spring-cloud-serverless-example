## SPRING CLOUD FUNCTION EXAMPLE PROJECT

#### AWS Serverless Lambda Function name - subscriber
#### Available functions to invoke

<ol>
<li>addEmail - HTTP POST method to add email</li>
<li>getEmailList - HTTP GET method to get email list</li>
<li>getEmailById - HTTP GET method to get email list by email id</li>
<li>uppercase - HTTP ANY method to change the input String to uppercase</li>
<li>lowercase - HTTP ANY method to change the input String to lowercase</li>
<li>reverse - HTTP ANY method to change the input String to reverse</li>
<li>getAllProducts - HTTP GET method to invoke another lambda function internally
For Invoking Lambda function from another Lambda, the calling/parent function
must have an additional custom policy other than "AWSLambdaRole" and "AWSLambdaExecute" on its Role.
The custom policy must have below settings -
<pre>
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "Statement1",
            "Effect": "Allow",
            "Action": [
                "lambda:InvokeAsync"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
</pre>
</li>

</ol>

#### Note: To invoke a particular Function HTTP Header attribute "spring.cloud.function.definition" must be added with cloud function name as the value for mapping the request with the function.