
set IMAGE_NAME=hdev1004/qstudy
set CONTAINER_NAME=qstudy

echo Stopping and removing any running containers named %CONTAINER_NAME%...
docker stop %CONTAINER_NAME%
docker rm %CONTAINER_NAME%

echo Removing the image named %IMAGE_NAME%...
docker rmi %IMAGE_NAME%

echo Building the new image named %IMAGE_NAME%...
docker build -t %IMAGE_NAME% .

docker run -d --name %CONTAINER_NAME% -p 8080:8080 %IMAGE_NAME%

echo Pushing the image named %IMAGE_NAME% to Docker Hub...
docker push %IMAGE_NAME%
