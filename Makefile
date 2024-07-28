USERNAME=salmonllama
IMAGE=fashionscape-api
TAG := $(shell git describe --tags)
BUILD=${USERNAME}/${IMAGE}:${TAG}
LATEST=${USERNAME}/${IMAGE}:latest

docker:
	echo ${TAG}
	podman build -t ${BUILD} .
	podman tag ${BUILD} ${LATEST}