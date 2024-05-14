.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.7

clean:
	./gradlew clean

build:
	cd app && ./gradlew clean build

run:
	./gradlew run --args="-h"

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	cd app && ./gradlew jacocoTestReport

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app -h

check-updates:
	./gradlew dependencyUpdates

.PHONY: build