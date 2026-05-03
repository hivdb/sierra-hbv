VERSION=$(shell date -u +"%Y%m%d%H%M%S")
DOCKERREPO=$(shell ./scripts/get-docker-repo.sh)
PLATFORMS=linux/amd64,linux/arm64

build:
	@docker build -t ${DOCKERREPO} .

force-build:
	@docker build --no-cache -t ${DOCKERREPO} .

inspect-dev:
	@docker exec -it hivdb-sierra-hbv-dev /bin/bash

dev: build
	@docker rm -f hivdb-sierra-hbv-dev 2>/dev/null || true
	@docker run \
		--name=hivdb-sierra-hbv-dev \
		--volume ~/.aws:/root/.aws:ro \
		--env NUCAMINO_AWS_LAMBDA=nucamino-align-with:5 \
		--env CMS_STAGE=localhost \
		--rm -it --publish=8118:8080 ${DOCKERREPO} dev

release:
	@docker login
	@docker buildx build --platform ${PLATFORMS} \
		-t ${DOCKERREPO}:${VERSION} \
		-t ${DOCKERREPO}:latest \
		--push .
	@echo ${VERSION} > .latest-version

src/main/resources/aapcnt/%.json: src/main/resources/aapcnt/%.csv scripts/csv2json.py
	@python3 scripts/csv2json.py $<

src/main/resources/mutation-type-pairs.json: src/main/resources/mutation-type-pairs.csv scripts/csv2json.py
	@python3 scripts/csv2json.py $<

src/main/resources/conditional-comments.json: src/main/resources/conditional-comments.csv scripts/condcmts_csv2json.py
	@python3 scripts/condcmts_csv2json.py $< > $@
	@echo $@

src: $(patsubst %.csv, %.json, $(wildcard src/main/resources/aapcnt/*.csv) src/main/resources/mutation-type-pairs.json src/main/resources/conditional-comments.csv)

.PHONY: build dev release force-build inspect-dev
