#### Stage 1: Build the react application
FROM nginx:alpine
COPY nginx-dev.conf /etc/nginx/conf.d
# Expose port 80 to the Docker host, so we can access it
# from the outside.
EXPOSE 80


ENTRYPOINT ["nginx","-g","daemon off;"]
