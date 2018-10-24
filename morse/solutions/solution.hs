import qualified Data.Map.Strict as Map
import Control.Monad (forever, unless)
import System.IO (isEOF)

morse :: Map.Map String Char
morse = Map.fromList
  [
  (".-", 'A'),
  ("-...", 'B'),
  ("-.-.", 'C'),
  ("-..", 'D'),
  (".", 'E'),
  ("..-.", 'F'),
  ("--.", 'G'),
  ("....", 'H'),
  ("..", 'I'),
  (".---", 'J'),
  ("-.-", 'K'),
  (".-..", 'L'),
  ("--", 'M'),
  ("-.", 'N'),
  ("---", 'O'),
  (".--.", 'P'),
  ("--.-", 'Q'),
  (".-.", 'R'),
  ("...", 'S'),
  ("-", 'T'),
  ("..-", 'U'),
  ("...-", 'V'),
  (".--", 'W'),
  ("-..-", 'X'),
  ("-.--", 'Y'),
  ("--..", 'Z'),
  ("-----", '0'),
  (".----", '1'),
  ("..---", '2'),
  ("...--", '3'),
  ("....-", '4'),
  (".....", '5'),
  ("-....", '6'),
  ("--...", '7'),
  ("---..", '8'),
  ("----.", '9'),
  (".-...", '&'),
  (".----.", '\''),
  (".--.-.", '@'),
  ("-.--.-", ')'),
  ("-.--.", '('),
  ("---...", ':'),
  ("--..--", ','),
  ("-...-", '='),
  ("-.-.--", '!'),
  (".-.-.-", '.'),
  ("-....-", '-'),
  (".-.-.", '+'),
  (".-..-.", '"'),
  ("..--..", '?'),
  ("-..-.", '/')
  ]

translate :: String -> Char
translate x = case Map.lookup x morse
  of Nothing -> error ("Invalid string '" ++ x ++ "'")
     Just val -> val

translate_all :: [String] -> String
translate_all xs = map translate xs

main :: IO ()
main = do
  lines <- getLine
  loop

-- this was a mess to figure out
-- see https://stackoverflow.com/a/9754864
-- we can't use interact because it only deals with raw strings, not lines
loop :: IO ()
loop = do
  done <- isEOF
  unless done $ do
    current <- getLine
    putStrLn $ (translate_all . words) current
    loop
