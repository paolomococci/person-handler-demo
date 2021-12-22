# person-handler-demo

Hibernate ORM and Spring Boot demo in the Kotlin programming language

Attention, the data used in the test files are fanciful.
Inventions that do not correspond to any place, object or real person.
Thank you.
## Example of use

### I get sample items

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:53:31 GMT
Date: Mon, 08 Oct 2018 03:53:31 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Jenny",
      "surname" : "Johnson",
      "age" : 23,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/1"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Jeremy",
      "surname" : "Johnson",
      "age" : 21,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/2"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Nike",
      "surname" : "Jameson",
      "age" : 26,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/3"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Zoe",
      "surname" : "Red",
      "age" : 29,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/4"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Chloe",
      "surname" : "Green",
      "age" : 25,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/5"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Johnny",
      "surname" : "Bender",
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/6"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Sissy",
      "surname" : null,
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/7"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I create a new item

```shell
$ curl -v -i -H "Content-Type:application/json" -d "{\"name\":\"Paul\",\"surname\":\"Bender\",\"age\":\"37\"}" http://127.0.0.1:9090/api/persons
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> POST /api/persons HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 45
> 
* upload completely sent off: 45 out of 45 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Location: http://127.0.0.1:9090/api/persons/8
Location: http://127.0.0.1:9090/api/persons/8
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:53:57 GMT
Date: Mon, 08 Oct 2018 03:53:57 GMT

< 
{
  "name" : "Paul",
  "surname" : "Bender",
  "age" : 37,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/8"
    },
    "persons" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I read new item
```
$ curl -v -i http://127.0.0.1:9090/api/persons/8
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/8 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:54:12 GMT
Date: Mon, 08 Oct 2018 03:54:12 GMT

< 
{
  "name" : "Paul",
  "surname" : "Bender",
  "age" : 37,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/8"
    },
    "persons" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I ask once again a list of people

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:54:25 GMT
Date: Mon, 08 Oct 2018 03:54:25 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Jenny",
      "surname" : "Johnson",
      "age" : 23,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/1"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Jeremy",
      "surname" : "Johnson",
      "age" : 21,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/2"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Nike",
      "surname" : "Jameson",
      "age" : 26,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/3"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Zoe",
      "surname" : "Red",
      "age" : 29,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/4"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Chloe",
      "surname" : "Green",
      "age" : 25,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/5"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Johnny",
      "surname" : "Bender",
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/6"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Sissy",
      "surname" : null,
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/7"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Paul",
      "surname" : "Bender",
      "age" : 37,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/8"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I update the last item

```shell
$ curl -v -i -X PUT -H "Content-Type:application/json" -d "{\"name\":\"Peter\",\"surname\":\"Bender\",\"age\":\"27\"}" http://127.0.0.1:9090/api/persons/8
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> PUT /api/persons/8 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 46
> 
* upload completely sent off: 46 out of 46 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Location: http://127.0.0.1:9090/api/persons/8
Location: http://127.0.0.1:9090/api/persons/8
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:54:40 GMT
Date: Mon, 08 Oct 2018 03:54:40 GMT

< 
{
  "name" : "Peter",
  "surname" : "Bender",
  "age" : 27,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/8"
    },
    "persons" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I partial update the last item

```shell
$ curl -v -i -X PATCH -H "Content-Type:application/json" -d "{\"age\":\"27\"}" http://127.0.0.1:9090/api/persons/8
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> PATCH /api/persons/8 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 12
> 
* upload completely sent off: 12 out of 12 bytes
< HTTP/1.1 201 
HTTP/1.1 201 
< Location: http://127.0.0.1:9090/api/persons/8
Location: http://127.0.0.1:9090/api/persons/8
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:54:53 GMT
Date: Mon, 08 Oct 2018 03:54:53 GMT

< 
{
  "name" : "Peter",
  "surname" : "Bender",
  "age" : 27,
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/8"
    },
    "persons" : {
      "href" : "http://127.0.0.1:9090/api/persons"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I try to request a list of items with age equal to 27

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons/age/27
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/age/27 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:55:09 GMT
Date: Mon, 08 Oct 2018 03:55:09 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Peter",
      "surname" : "Bender",
      "age" : 27,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/8"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/age/27"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I try to request a list of items with name equal to Peter

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons/name/Peter
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/name/Peter HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:55:20 GMT
Date: Mon, 08 Oct 2018 03:55:20 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Peter",
      "surname" : "Bender",
      "age" : 27,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/8"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/name/Peter"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I try to request a list of items with surname equal to Bender

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons/surname/Bender
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/surname/Bender HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:55:31 GMT
Date: Mon, 08 Oct 2018 03:55:31 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Johnny",
      "surname" : "Bender",
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/6"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    }, {
      "name" : "Peter",
      "surname" : "Bender",
      "age" : 27,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/8"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/surname/Bender"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```

### I delete the latest item

```shell
$ curl -v -i -X DELETE http://127.0.0.1:9090/api/persons/8
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> DELETE /api/persons/8 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 204 
HTTP/1.1 204 
< Date: Mon, 08 Oct 2018 03:55:50 GMT
Date: Mon, 08 Oct 2018 03:55:50 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
```

### I try to request the last item on the list just deleted

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons/8
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/8 HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 404 
HTTP/1.1 404 
< Content-Type: text/plain;charset=UTF-8
Content-Type: text/plain;charset=UTF-8
< Content-Length: 27
Content-Length: 27
< Date: Mon, 08 Oct 2018 03:57:18 GMT
Date: Mon, 08 Oct 2018 03:57:18 GMT

< 
* Connection #0 to host 127.0.0.1 left intact
could not find person id: 8
```

### I again get a list of items with name equal to Bender

```shell
$ curl -v -i http://127.0.0.1:9090/api/persons/surname/Bender
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 9090 (#0)
> GET /api/persons/surname/Bender HTTP/1.1
> Host: 127.0.0.1:9090
> User-Agent: curl/7.59.0
> Accept: */*
> 
< HTTP/1.1 200 
HTTP/1.1 200 
< Content-Type: application/hal+json;charset=UTF-8
Content-Type: application/hal+json;charset=UTF-8
< Transfer-Encoding: chunked
Transfer-Encoding: chunked
< Date: Mon, 08 Oct 2018 03:57:33 GMT
Date: Mon, 08 Oct 2018 03:57:33 GMT

< 
{
  "_embedded" : {
    "persons" : [ {
      "name" : "Johnny",
      "surname" : "Bender",
      "age" : null,
      "_links" : {
        "self" : {
          "href" : "http://127.0.0.1:9090/api/persons/6"
        },
        "persons" : {
          "href" : "http://127.0.0.1:9090/api/persons"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:9090/api/persons/surname/Bender"
    }
  }
* Connection #0 to host 127.0.0.1 left intact
}
```
