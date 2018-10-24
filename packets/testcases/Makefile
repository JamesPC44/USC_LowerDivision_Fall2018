BASE_NAME=packets_testcases

$(BASE_NAME).zip: *.input *.output
	mkdir -p $(BASE_NAME)
	mkdir -p $(BASE_NAME)/input
	mkdir -p $(BASE_NAME)/output
	for f in *.input ; do cp "$$f" "$(BASE_NAME)/input/$$(echo "$$f" | sed 's/input/txt/g' | sed 's/test/input/g')" ; done
	for f in *.output ; do cp "$$f" "$(BASE_NAME)/output/$$(echo "$$f" | sed 's/output/txt/g' | sed 's/test/output/g')" ; done
	cd $(BASE_NAME) && zip --recurse-paths $(BASE_NAME).zip input output
	mv $(BASE_NAME)/*.zip ./

clean:
	rm -rf $(BASE_NAME)
	rm -f $(BASE_NAME).zip
