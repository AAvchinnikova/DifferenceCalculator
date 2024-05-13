run-dist:
	./build/install/app/bin/app filepath1.json filepath2.json

clean:
	./gradlew clean

build:
	./gradlew clean build

run:
	./gradlew run

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

help:
	./build/install/app/bin/app -h

build-run: build run

.PHONY: build