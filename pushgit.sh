	#!/bin/bash
	clear
    git flow feature start internationalisation
    git add .
    git commit -m "internationalisation"
    git flow feature finish internationalisation
    git push origin develop
