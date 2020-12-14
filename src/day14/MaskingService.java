package day14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public interface MaskingService {
    static void applyMaskV1(String mask, BitSet bitSet) {
        for (int i = mask.length() - 1; i >= 0; i--) {
            char c = mask.charAt(i);
            switch (c) {
                case 'X': {
                    break;
                }
                case '1': {
                    bitSet.set(mask.length() -1 -i);
                    break;
                }
                case '0': {
                    bitSet.clear(mask.length() -1 -i);
                    break;
                }
            }
        }
    }

    static List<BitSet> applyMaskV2(String mask, BitSet bitSet) {
        List<BitSet> ans = new ArrayList<>();
        ans.add(bitSet);

        for (int i = mask.length() -1; i >= 0; i--) {
            char c = mask.charAt(i);
            switch (c) {
                case 'X': {
                    List<BitSet> newNumbers = new ArrayList<>();
                    for (BitSet bs : ans) {
                        newNumbers.add((BitSet) bs.clone());
                        bs.set(mask.length() -1 -i);
                    }
                    for (BitSet bs : newNumbers) {
                        bs.clear(mask.length() -1 -i);
                    }
                    ans.addAll(newNumbers);
                    break;
                }
                case '1': {
                    for (BitSet bs : ans) {
                        bs.set(mask.length() -1 -i);
                    }
                    break;
                }
                case '0': {
                    break;
                }
            }
        }

        return ans;
    }
}
