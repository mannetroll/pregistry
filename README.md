# pregistry

    docker pull docker.elastic.co/package-registry/distribution:lite-8.11.3
    docker save -o package-registry-lite-8.11.3.tar docker.elastic.co/package-registry/distribution:lite-8.11.3
    docker load -i package-registry-lite-8.11.3.tar

    docker run -it -p 8088:8080 docker.elastic.co/package-registry/distribution:lite-8.11.3

    curl -is "http://127.0.0.1:2020/search?package=apm&prerelease=false&kibana.version=8.11.3"
    curl -is "http://127.0.0.1:2020/search?package=synthetics&prerelease=true&kibana.version=8.11.3"
    curl -is "http://127.0.0.1:2020/search?kibana.version=8.11.3"
    curl -is "http://127.0.0.1:2020/categories?kibana.version=8.11.3"
    
# kibana

    xpack.fleet.registryUrl: "http://127.0.0.1:2020"
    xpack.fleet.packages:
    - name: apm
      version: latest
       
