	#!/bin/bash
	clear
    git flow feature start App_Disapp
    git add .
    git commit -m "App_Disapp"
    git flow feature finish App_Disapp
    git push origin develop
