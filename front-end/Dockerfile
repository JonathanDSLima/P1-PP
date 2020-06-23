FROM node:alpine as builder

RUN mkdir /restaurant-client
COPY . ./restaurant-client/

WORKDIR /restaurant-client

RUN npm i

RUN npm run ng build -- --prod --output-path=dist --buildOptimizer=true

FROM nginx:alpine
EXPOSE 80
COPY --from=builder ./restaurant-client/nginx-custom.conf /etc/nginx/conf.d/default.conf
COPY --from=builder ./restaurant-client/dist /usr/share/nginx/html
