# java-idol-indexing-api

This is a Java API for indexing documents into IDOL servers.

## About
IDOL servers use an index port for indexing content. This library provides a Java API for performing this task.

Previous versions were available as jar files from customer support.

## Usage
java-idol-indexing-api is available from the central Maven repository.

    <dependency>
        <groupId>com.hp.autonomy.idol</groupId>
        <artifactId>indexing-api</artifactId>
        <version>3.0.0</version>
    </dependency>

The primary means of interaction is the IndexingService. An IndexingServiceImpl can either be created with the host and index 
port for an IDOL server, or the executeAction method must be called with a host and port each time.

    final IndexingService indexingService = new IndexingServiceImpl(
        new DefaultHttpClient(),
        new ServerDetails(host, port)
    );

Subclasses of IndexCommand are used to send index commands. For example, to create a DREADD command:

    final IndexCommand command = new DreAddCommand();
    command.setIndexFile("/path/to/my/file");

To execute this command, the IndexingService executeCommand method should be called with the action. The index id of the
index job is returned.

    final int indexId = indexingService.executeCommand(command);

Use the [Java ACI API](https://github.com/microfocus-idol/java-aci-api-ng) to track the status of the job.

## Migration to FOSS Version
There are no substantial differences between the open source version and previous versions.

## Contributing
We welcome pull requests. These must be licensed under the MIT license. Please submit pull requests to the develop
branch - the master branch is for stable code only.

## Is it any good?
Yes.

## License

(c) Copyright 2008-2015 Micro Focus or one of its affiliates.

Licensed under the MIT License (the "License"); you may not use this project except in compliance with the License.
