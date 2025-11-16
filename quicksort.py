def quicksort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return quicksort(left) + middle + quicksort(right)


def main():
    # Test cases
    test_cases = [
        [3, 6, 8, 10, 1, 2, 1],
        [5, 2, 9, 1, 7, 6, 3],
        [],
        [1],
        [2, 1],
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
    ]

    for i, arr in enumerate(test_cases):
        sorted_arr = quicksort(arr)
        print(f"Test {i + 1}: {arr} -> {sorted_arr}")
        assert sorted_arr == sorted(arr), f"Test {i + 1} failed!"

    print("\nAll tests passed!")


if __name__ == "__main__":
    main()
