from setuptools import setup, find_packages

setup(
    name='apiverve_reversegeocode',
    version='1.2.6',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Reverse Geocode converts latitude and longitude coordinates into US, Canada and Australia location details. Pass geographic coordinates to retrieve the corresponding city, state, postal code, country code, time zone and US county. Paid plans can add the point's geohash, plus code and degrees-minutes-seconds notation.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/reversegeocode?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
