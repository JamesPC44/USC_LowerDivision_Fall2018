import qualified Data.Map.Strict as Map  -- faster than Map.Lazy for primitive values
import Control.Monad

-- take a set in format "[a-z]"
normalize_set set = [set !! 1 .. set !! 3]

normalize_all_sets (c:xs) = if c == '['
  then (normalize_set $ c:take 4 xs) ++ (normalize_all_sets $ drop 4 xs)
  else c:normalize_all_sets xs
normalize_all_sets c = c

translate x map = case (Map.lookup x map) of
  Nothing -> x
  Just val -> val

translate_all xs m = map (\x -> translate x m) xs

main = do
  input_string <- getLine
  output_string <- getLine
  getLine  -- ignored; lines to follow
  let input_pattern = normalize_all_sets input_string
      output_pattern = normalize_all_sets output_string
      io_map = Map.fromList $ zip input_pattern output_pattern
  interact (\input -> translate_all input io_map)
