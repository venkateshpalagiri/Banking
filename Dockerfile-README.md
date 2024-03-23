Open cmd go to the project locaiton

Build a docker image
>docker build -t [docker-image-name]:latest .

Run docker image in a container
>docker run -p 8081:8080 [docker-image-name]
