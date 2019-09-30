echo 'Starting bash script'


combinedParams = ""

for param in "$@"
do
    combinedParams="${combinedParams} ${param}"
done

echo "${combinedParams}"