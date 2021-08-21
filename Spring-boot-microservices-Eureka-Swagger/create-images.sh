sudo docker image rm pc1204a/authorization-server:v01 pc1204a/api-gateway:v01 pc1204a/applyjobservice:v01 pc1204a/candidate-service:v01 pc1204a/configurations-server:v01 pc1204a/netflix-eureka-server:v0.1

cd configurations-server/
sudo docker build -t pc1204a/configurations-server:v01 .

cd ../netflix-eureka-server/
sudo docker build -t pc1204a/netflix-eureka-server:v01 .

cd ../api-gateway/
sudo docker build -t pc1204a/api-gateway:v01 .

cd ../CandidateServices/
sudo docker build -t pc1204a/candidate-service:v01 .

cd ../central-oauth2-server/
sudo docker build -t pc1204a/authorization-server:v01 .

cd ../applyjobservice/
sudo docker build -t pc1204a/applyjobservice:v01 .

