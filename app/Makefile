run-dist:
	./build/install/app/bin/app build/resources/test/file1.json build/resources/test/file2.json

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

.PHONY: build