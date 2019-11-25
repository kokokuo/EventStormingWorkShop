# Deploy Coffeeshop application through AWS Code* Suite with AWS CDK



**Kudos for your insist learning from this repository. It's time to deploy the applications to real AWS environment.**





![](../img/EventStormingWorkshop-CDK.jpg)

To deploy applications to AWS, you need to have the following essential tools installed:

* [AWS CLI](https://docs.aws.amazon.com/zh_tw/cli/latest/userguide/cli-chap-install.html)
* [AWS CDK](https://docs.aws.amazon.com/cdk/latest/guide/getting_started.html)



**Deploy instruction**

```shell script
cd deployment/coffeeshop-cdk

npm run build 

cdk synth

cdk deploy CoffeeShopCdkStack 
cdk deploy CoffeeShopCodePipeline 
```



**Installed Resources**

* VPC with standard 3 AZs, 1 NAT Gateway, Public and Private subnets defnied
* EventBridge
* CloudWatch Rule
* Dynamodb
* ECR
* Fargate Cluster, Fargate Service, ECS Task definition
* Lambda function