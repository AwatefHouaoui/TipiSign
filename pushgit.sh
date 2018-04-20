	#!/bin/bash
	clear
    git flow feature start see.more.function
    git add .
    git commit -m "see.more.function"
    git flow feature finish see.more.function
    git push origin develop
