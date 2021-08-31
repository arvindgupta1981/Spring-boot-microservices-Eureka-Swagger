sudo docker stop eureka-service-registry
sudo docker stop configurations-server
sudo docker stop candidate-service
sudo docker stop mysqldb

sudo docker rm candidate-service
sudo docker rm configurations-server
sudo docker rm eureka-service-registry
sudo docker rm mysqldb

sudo docker ps -a

sudo docker-compose up -d --scale candidate-service=2

sudo docker inspect configurations-server
sudo docker logs configurations-server
sudo docker exec -it configurations-server bash
sudo docker exec -it configurations-server hostname
