cd /home/arvind/workspace_microservices/Spring-boot-microservices-Eureka-Swagger/Spring-boot-microservices-Eureka-Swagger/configurations-server
sudo docker build -t pc1204a/configurations-server:v0.1 .
cd /home/arvind/workspace_microservices/Spring-boot-microservices-Eureka-Swagger/Spring-boot-microservices-Eureka-Swagger/netflix-eureka-server
sudo docker build -t  pc1204a/netflix-eureka-server:v0.1
cd /home/arvind/workspace_microservices/Spring-boot-microservices-Eureka-Swagger/Spring-boot-microservices-Eureka-Swagger/api-gateway
sudo docker build -t  pc1204a/api-gateway:v01 .
sudo docker build -t  pc1204a/configurations-server:v01 .
