
build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app build/resources/test/file1.json build/resources/test/file2.json

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

.PHONY: build