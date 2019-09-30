combinedParams = ""

for param in "$@"
do
    combinedParams="${combinedParams} ${param}"
done

echo "${combinedParams}"

cewlCommand="echo"
fullComand="${cewlCommand} ${combinedParams}"

eval ${fullComand}