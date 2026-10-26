from setuptools import setup, find_packages

setup(
    name='apiverve_reversegeocode',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Reverse Geocode converts latitude and longitude coordinates into US and Canada location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, and country code.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/reversegeocode?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
