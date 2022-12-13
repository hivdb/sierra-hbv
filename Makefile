VERSION=$(shell date -u +"%Y%m%d%H%M%S")
DOCKERREPO=$(shell ./scripts/get-docker-repo.sh)

build:
	@docker pull hivdb/tomcat-with-nucamino:latest
	@docker build -t ${DOCKERREPO} .

force-build:
	@docker pull hivdb/tomcat-with-nucamino:latest
	@docker build --no-cache -t ${DOCKERREPO} .

inspect-dev:
	@docker exec -it hivdb-sierra-ebv-dev /bin/bash

dev: build
	@docker rm -f hivdb-sierra-ebv-dev 2>/dev/null || true
	@docker run \
		--name=hivdb-sierra-ebv-dev \
		--volume ~/.aws:/root/.aws:ro \
		--env NUCAMINO_AWS_LAMBDA=nucamino-align-with:5 \
		--env CMS_STAGE=localhost \
		--rm -it --publish=8117:8080 ${DOCKERREPO} dev

release: build
	@docker login
	@docker tag ${DOCKERREPO}:latest ${DOCKERREPO}:${VERSION}
	@docker push ${DOCKERREPO}:${VERSION}
	@docker push ${DOCKERREPO}:latest
	@echo ${VERSION} > .latest-version
	@sleep 2

.PHONY: build
