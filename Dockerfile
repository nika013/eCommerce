# Use openjdk 11 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /ecommerceapp

# Copy the compiled Java classes and other required files to the container
COPY target/classes/ .

# Specify the command to run the application
CMD ["java", "-cp", ".:lib/*", "org.example.Main"]
