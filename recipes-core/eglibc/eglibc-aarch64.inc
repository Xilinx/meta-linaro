PRINC = "4"

SRC_URI_append = " \
                  http://people.linaro.org/~toolchain/openembedded/patches/eglibc/aarch64-0001-glibc-fsf-v1-eaf6f205.patch;name=aarch64-1 \
                  http://people.linaro.org/~toolchain/openembedded/patches/eglibc/aarch64-0002-Synchronize-with-linux-elf.h.patch;name=aarch64-2 \
                  http://people.linaro.org/~toolchain/openembedded/patches/eglibc/aarch64-0003-Adding-AArch64-support-to-elf-elf.h.patch;name=aarch64-3 \
"

SRC_URI[aarch64-1.md5sum] = "5e52bf8fd9ac390b665d86a57ab7dba7"
SRC_URI[aarch64-1.sha256sum] = "b7eea76e72675a6ed3066952a9e08389c99838d74a58b736d527c82c34e754eb"
SRC_URI[aarch64-2.md5sum] = "e1ae1c416c01e2c991c7ca7e169c577b"
SRC_URI[aarch64-2.sha256sum] = "6093bb80a187081090cb14412f466c08fcaf39ccd62b751e3d871a8c5af03b0d"
SRC_URI[aarch64-3.md5sum] = "6d1d84e14f7abfe9ee3237d0ec6fe9ca"
SRC_URI[aarch64-3.sha256sum] = "03e79ace9eade0d57a3684cb0dc6b415ea52e4f152bfb380684b08445f125410"
