# selenoid
Simple selenoid project

# Configuration

## Populate the following file:

C:\Users\...\.aerokube\selenoid\browsers.json

with:

```json
{
    "chrome": {
        "default": "91.0",
        "versions": {
            "91.0": {
                "image": "selenoid/vnc_chrome:91.0",
                "port": "4444",
                "path": "/"
            }
        }
    }
}
```
## Initialize the selenoid for VNC support:

```
.\cm selenoid update --vnc
```

## Run this demo

```
.\gradlew.bat test
```

Sit back and enjoy!